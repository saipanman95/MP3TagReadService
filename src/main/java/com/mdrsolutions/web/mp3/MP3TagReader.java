/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.mp3;

import com.mdrsolutions.web.mp3.model.MP3Tag;
import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

/**
 *
 * @author michael
 */
public interface MP3TagReader {
    MP3Tag readMp3Tag(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException;
}
