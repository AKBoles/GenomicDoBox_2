package ch.cyberduck.core.sftp;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.ch
 */

import ch.cyberduck.core.LoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.shared.ThreadedDeleteFeature;

import java.io.IOException;
import java.util.List;

public class SFTPDeleteFeature extends ThreadedDeleteFeature implements Delete {

    private SFTPSession session;

    public SFTPDeleteFeature(final SFTPSession session) {
        this.session = session;
    }

    @Override
    public void delete(final List<Path> files, final LoginCallback prompt, final Callback callback) throws BackgroundException {
        for(Path file : files) {
            if(file.isFile() || file.isSymbolicLink()) {
                this.submit(file, new Implementation() {
                    @Override
                    public void delete(final Path file) throws BackgroundException {
                        callback.delete(file);
                        try {
                            session.sftp().remove(file.getAbsolute());
                        }
                        catch(IOException e) {
                            throw new SFTPExceptionMappingService().map("Cannot delete {0}", e, file);
                        }
                    }
                });
            }
        }
        // Await and shutdown
        this.await();
        for(Path file : files) {
            if(file.isDirectory()) {
                callback.delete(file);
                try {
                    session.sftp().removeDir(file.getAbsolute());
                }
                catch(IOException e) {
                    throw new SFTPExceptionMappingService().map("Cannot delete {0}", e, file);
                }
            }
        }
    }
}
