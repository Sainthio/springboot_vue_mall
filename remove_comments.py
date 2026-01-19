#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import os
import re

def remove_java_comments(content):
    lines = content.split('\n')
    result = []
    in_block_comment = False
    
    for line in lines:
        if in_block_comment:
            if '*/' in line:
                in_block_comment = False
                line = line[line.find('*/') + 2:]
            else:
                continue
        
        while '/*' in line and '*/' in line:
            start = line.find('/*')
            end = line.find('*/', start) + 2
            line = line[:start] + line[end:]
        
        if '/*' in line:
            in_block_comment = True
            line = line[:line.find('/*')]
        
        if '//' in line:
            comment_pos = line.find('//')
            if comment_pos != -1:
                in_string = False
                for i in range(comment_pos):
                    if line[i] == '"' and (i == 0 or line[i-1] != '\\'):
                        in_string = not in_string
                if not in_string:
                    line = line[:comment_pos].rstrip()
        
        if line.strip():
            result.append(line)
        else:
            result.append('')
    
    return '\n'.join(result)

def process_java_files(directory):
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.java'):
                filepath = os.path.join(root, file)
                try:
                    with open(filepath, 'r', encoding='utf-8') as f:
                        content = f.read()
                    
                    new_content = remove_java_comments(content)
                    
                    with open(filepath, 'w', encoding='utf-8') as f:
                        f.write(new_content)
                    
                    print(f'Processed: {filepath}')
                except Exception as e:
                    print(f'Error processing {filepath}: {e}')

if __name__ == '__main__':
    java_dir = 'springbootol3q1/src/main/java'
    if os.path.exists(java_dir):
        process_java_files(java_dir)
        print('All Java files processed!')
    else:
        print(f'Directory {java_dir} not found!')
