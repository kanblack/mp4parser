package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;

import java.nio.ByteBuffer;

/**
 * This atom carries the pixel dimensions of the track’s encoded pixels.
 * The type of the track encoded pixels dimensions atom is 'enof'.
 */
public class TrackEncodedPixelsDimensionsAtom extends AbstractFullBox {
    public static final String TYPE = "enof";

    double width;
    double height;

    public TrackEncodedPixelsDimensionsAtom() {
        super(TYPE);
    }


    @Override
    protected long getContentSize() {
        return 12;
    }

    @Override
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, width);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, height);
    }

    @Override
    protected void _parseDetails(ByteBuffer content) {
        parseVersionAndFlags(content);
        width = IsoTypeReader.readFixedPoint1616(content);
        height = IsoTypeReader.readFixedPoint1616(content);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

