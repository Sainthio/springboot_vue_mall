import argparse
import zipfile
import xml.etree.ElementTree as ET


W_NS = "http://schemas.openxmlformats.org/wordprocessingml/2006/main"
NS = {"w": W_NS}


def extract_paragraph_texts(docx_path: str) -> list[str]:
    with zipfile.ZipFile(docx_path) as z:
        xml = z.read("word/document.xml")

    root = ET.fromstring(xml)
    out: list[str] = []
    for p in root.findall(".//w:p", NS):
        texts = [t.text for t in p.findall(".//w:t", NS) if t.text]
        line = "".join(texts).strip()
        if line:
            out.append(line)
    return out


def main() -> None:
    parser = argparse.ArgumentParser(description="Extract docx body text (w:t) lines.")
    parser.add_argument("docx", help="Path to .docx file")
    parser.add_argument("--head", type=int, default=400, help="Print first N non-empty lines")
    parser.add_argument(
        "--tail", type=int, default=0, help="Print last N non-empty lines (0 disables)"
    )
    args = parser.parse_args()

    lines = extract_paragraph_texts(args.docx)
    if args.head and args.head > 0:
        print("\n".join(lines[: args.head]))
    if args.tail and args.tail > 0:
        print("\n".join(lines[-args.tail :]))


if __name__ == "__main__":
    main()

