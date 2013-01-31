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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Hochenwiseler
{

    private JProgressBar[] _barArr;

    private Map<Character, ArrayList<String>> _hashmap;

    private Collection<String> _allWords;

    public Hochenwiseler()
    {

        FileScanner scanner = null;
        try
        {
            scanner = new FileScanner();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        JFrame frame = new JFrame("SUPER AWESOME");

        frame.setLayout(new VerticalLayout(VerticalLayout.CENTER));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _barArr = new JProgressBar[26];
        for (int i = 0; i < _barArr.length; i++)
        {
            final char c = (char) ('a' + i);
            JProgressBar bar = new JProgressBar();
            bar.setString("" + c);
            bar.setStringPainted(true);
            _barArr[i] = bar;
            bar.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    executeTask(c);
                }
            });
            frame.add(_barArr[i]);

        }

        if (scanner != null)
        {
            _hashmap = scanner.hashmap;

            for (char c : _hashmap.keySet())
            {
                _barArr[c - 'a'].setString("" + c + " : " + _hashmap.get(c).size());
            }
            _allWords = scanner.allWords;
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void executeTask(char beginningCharacter)
    {
        new DictTask(_hashmap.get(beginningCharacter), _allWords, _barArr[beginningCharacter - 'a']).execute();
    }
}
