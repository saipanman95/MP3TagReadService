/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.mp3.impl;

import com.mdrsolutions.web.mp3.MP3FileReader;
import java.io.File;
import org.springframework.stereotype.Service;

/**
 *
 * @author michael
 */
@Service("mp3FileReader")
public class MP3FileReaderImpl implements MP3FileReader{

    public File findMp3(String fileLocation) {
        File f = new File(fileLocation);
        
        if (f.exists() ) {
            return f;
        } else {
            return null;
        }
        
        
    }
    
}
