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

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class DictTask extends SwingWorker<Object, Object>
{

    private final JProgressBar _progressbar;

    private final ArrayList<String> _firstWords;

    private final Collection<String> _allWords;

    private int _count = 0;

    public DictTask(ArrayList<String> firstWords, Collection<String> allWords, JProgressBar progressbar)
    {
        _firstWords = firstWords;
        _allWords = allWords;
        _progressbar = progressbar;
        _progressbar.setMaximum(_firstWords.size());
    }

    @Override
    protected Object doInBackground() throws Exception
    {
        for (String first : _firstWords)
        {
            int hashcode = first.hashCode();
            for (String second : _allWords)
            {
                if (first.length() + second.length() >= 7)
                {
                    int calculated = HashCoder.getHashCode(hashcode, second);
                    if (calculated == Integer.MIN_VALUE)
                    {
                        System.out.print(first.toLowerCase());
                        System.out.println(second.toLowerCase());
                    }
                }
            }
            ++_count;
            _progressbar.setValue(_count);
        }
        _progressbar.setString(_progressbar.getString() + " DONE");
        return null;
    }

}
