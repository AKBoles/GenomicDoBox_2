package ch.cyberduck.core;

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
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

public class VersioningConfiguration {

    public static VersioningConfiguration empty() {
        return new VersioningConfiguration();
    }

    private boolean enabled;

    /**
     * Authentication
     */
    private boolean multifactor;

    public VersioningConfiguration() {
        this(false);
    }

    public VersioningConfiguration(final boolean enabled) {
        this(enabled, false);
    }

    public VersioningConfiguration(final boolean enabled, final boolean multifactor) {
        this.enabled = enabled;
        this.multifactor = multifactor;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isMultifactor() {
        return multifactor;
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final VersioningConfiguration that = (VersioningConfiguration) o;
        if(enabled != that.enabled) {
            return false;
        }
        if(multifactor != that.multifactor) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = (enabled ? 1 : 0);
        result = 31 * result + (multifactor ? 1 : 0);
        return result;
    }
}
