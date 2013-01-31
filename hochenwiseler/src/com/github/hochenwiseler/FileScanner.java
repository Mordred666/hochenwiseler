/*
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2013 Wolf Posdorfer
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 */
package com.github.hochenwiseler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FileScanner
{

    Map<Character, ArrayList<String>> hashmap = new HashMap<Character, ArrayList<String>>();
    Collection<String> allWords = new HashSet<String>();

    public FileScanner() throws IOException
    {
        for (char c = 'a'; c <= 'z'; c++)
        {
            hashmap.put(c, new ArrayList<String>());
        }

        File input = new File("dictionary.txt");

        FileReader reader = new FileReader(input);

        BufferedReader buf = new BufferedReader(reader);

        String line = "";

        while ((line = buf.readLine()) != null)
        {
            line = line.trim();

            char c = line.charAt(0);

            if (c >= 'A' && c <= 'Z')
            {
                System.out.println("OHOH: " + line);
                continue;
            }

            if (c < 'a' && c > 'z')
            {
                System.out.println("OHOH: " + line);
                continue;
            }

            if (line != null && !line.endsWith("raumes") && !line.endsWith("verbots"))
            {

                allWords.add(line);
                hashmap.get(c).add(line);
            }
        }

        buf.close();
        reader.close();
    }
}
