package com.pro.util;

import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ObjectId implements Comparable<ObjectId>, java.io.Serializable {
    private final int _time;
    private final int _machine;
    private final int _inc;
    private boolean _new;
    private static final int _genmachine;
    private static AtomicInteger _nextInc = new AtomicInteger((new java.util.Random()).nextInt());
    private static final long serialVersionUID = -4415279469780082174L;
    private static final Logger LOGGER = Logger.getLogger("com.pro.util.ObjectId");

    private ObjectId() {
        _time = (int) (System.currentTimeMillis() / 1000);
        _machine = _genmachine;
        _inc = _nextInc.getAndIncrement();
        _new = true;
    }
    /***
     * 获取唯一ID
     * @return
     */
    public static String getId() {
        return new ObjectId().toHexString();
    }
    /***
     * 验证ID是否有效
     * @param id
     * @return
     */
    public static boolean isValid(String id) {
        if (id == null)
            return false;
        final int len = id.length();
        if (len != 24)
            return false;
        for (int i = 0; i < len; i++) {
            char c = id.charAt(i);
            if (c >= '0' && c <= '9')
                continue;
            if (c >= 'a' && c <= 'f')
                continue;
            if (c >= 'A' && c <= 'F')
                continue;
            return false;
        }
        return true;
    }
    
    /***
     * 获取id生成的时间
     * @param id
     * @return
     */
    public static Date getInitDate(String id){
    	if(isValid(id)){
    		return new Date(1000l * Integer.parseInt(id.substring(0, 8), 16));
    	}
    	return null;
    }

    private String toHexString() {
        final StringBuilder buf = new StringBuilder(24);
        for (final byte b : toByteArray()) {
            buf.append(String.format("%02x", b & 0xff));
        }
        return buf.toString();
    }

    private byte[] toByteArray() {
        byte b[] = new byte[12];
        ByteBuffer bb = ByteBuffer.wrap(b);
        bb.putInt(_time);
        bb.putInt(_machine);
        bb.putInt(_inc);
        return b;
    }
    
    private int _compareUnsigned(int i, int j) {
        long li = 0xFFFFFFFFL;
        li = i & li;
        long lj = 0xFFFFFFFFL;
        lj = j & lj;
        long diff = li - lj;
        if (diff < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (diff > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) diff;
    }
    
    public int compareTo(ObjectId id) {
        if (id == null)
            return -1;
        int x = _compareUnsigned(_time, id._time);
        if (x != 0)
            return x;
        x = _compareUnsigned(_machine, id._machine);
        if (x != 0)
            return x;
        return _compareUnsigned(_inc, id._inc);
    }
    
    static {
        try {
            int machinePiece;
            {
                try {
                    StringBuilder sb = new StringBuilder();
                    Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
                    while (e.hasMoreElements()) {
                        NetworkInterface ni = e.nextElement();
                        sb.append(ni.toString());
                    }
                    machinePiece = sb.toString().hashCode() << 16;
                } catch (Throwable e) {
                    LOGGER.log(Level.WARNING, e.getMessage(), e);
                    machinePiece = (new Random().nextInt()) << 16;
                }
                LOGGER.fine("machine piece post: " + Integer.toHexString(machinePiece));
            }
            final int processPiece;
            {
                int processId = new java.util.Random().nextInt();
                try {
                    processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
                } catch (Throwable t) {
                }
                ClassLoader loader = ObjectId.class.getClassLoader();
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toHexString(processId));
                sb.append(Integer.toHexString(loader != null ? System.identityHashCode(loader) : 0));
                processPiece = sb.toString().hashCode() & 0xFFFF;
                LOGGER.fine("process piece: " + Integer.toHexString(processPiece));
            }
            _genmachine = machinePiece | processPiece;
            LOGGER.fine("machine : " + Integer.toHexString(_genmachine));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("static-access")
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectId that = (ObjectId) o;
        return Objects.equals(this.serialVersionUID, that.serialVersionUID) &&
                Objects.equals(this.LOGGER, that.LOGGER) &&
                Objects.equals(this._time, that._time) &&
                Objects.equals(this._machine, that._machine) &&
                Objects.equals(this._inc, that._inc) &&
                Objects.equals(this._new, that._new) &&
                Objects.equals(this._nextInc, that._nextInc) &&
                Objects.equals(this._genmachine, that._genmachine);
    }
 
}