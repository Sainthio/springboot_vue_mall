#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import os
import re

def remove_java_comments(content):
    content = re.sub(r'/\*\*[\s\S]*?\*/', '', content)
    lines = content.split('\n')
    result = []
    
    for line in lines:
        stripped = line.strip()
        if not stripped or stripped.startswith('*'):
            result.append('')
            continue
            
        if '//' in line:
            comment_pos = line.find('//')
            if comment_pos != -1:
                in_string = False
                quote_char = None
                for i in range(comment_pos):
                    char = line[i]
                    if char in ['"', "'"]:
                        if i == 0 or line[i-1] != '\\':
                            if not in_string:
                                in_string = True
                                quote_char = char
                            elif char == quote_char:
                                in_string = False
                                quote_char = None
                if not in_string:
                    line = line[:comment_pos].rstrip()
        
        result.append(line)
    
    content = '\n'.join(result)
    content = re.sub(r'\n\s*\n\s*\n+', '\n\n', content)
    return content

def process_java_files(directory):
    count = 0
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.java'):
                filepath = os.path.join(root, file)
                try:
                    with open(filepath, 'r', encoding='utf-8') as f:
                        content = f.read()
                    
                    new_content = remove_java_comments(content)
                    
                    with open(filepath, 'w', encoding='utf-8', newline='') as f:
                        f.write(new_content)
                    
                    count += 1
                    if count % 10 == 0:
                        print(f'Processed {count} files...')
                except Exception as e:
                    print(f'Error processing {filepath}: {e}')
    
    return count

if __name__ == '__main__':
    java_dir = 'springbootol3q1/src/main/java'
    if os.path.exists(java_dir):
        print(f'Starting to process Java files in {java_dir}...')
        count = process_java_files(java_dir)
        print(f'Completed! Processed {count} Java files.')
    else:
        print(f'Directory {java_dir} not found!')
