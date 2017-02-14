package ns.learning.patterns.state.visa.service

abstract class VisaUtil {

    static final byte STX = 2
    static final byte ETX = 3
    static final byte EOT = 4
    static final byte ACK = 6
    static final byte NAK = 0x15

    static byte calculateLrc(byte[] bytes) {
        int lrc = 0

        bytes.eachByte { b -> lrc ^= b }

        lrc ^= ETX

        return (byte) lrc
    }

}
