package kcue.common.util;

import java.io.Serializable;
import java.security.SecureRandom;

/**  
 * @Class Name : UUIT.java
 * @Description : UUIT Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2012.06.14           최초생성
 * 
 * @author 폭스소프트 개발팀
 * @since 2012.06.14
 * @version 1.0
 * @see
 */
public final class UUIT implements Serializable, Comparable {
    private UUIT(byte abyte0[]) { 
        hashCode = -1;
        long l = 0L;
        long l1 = 0L;
        if( abyte0.length != 16)
            throw new AssertionError();
        for(int i = 0; i < 8; i++)
            l = l << 8 | (long)(abyte0[i] & 0xff);

        for(int j = 8; j < 16; j++)
            l1 = l1 << 8 | (long)(abyte0[j] & 0xff);

        mostSigBits = l;
        leastSigBits = l1;
    }
 
    public static UUIT randomUUID() {
        SecureRandom securerandom = numberGenerator;
        if(securerandom == null)
            numberGenerator = securerandom = new SecureRandom();
        byte abyte0[] = new byte[16];
        securerandom.nextBytes(abyte0);
        abyte0[6] &= 0xf;
        abyte0[6] |= 0x40;
        abyte0[8] &= 0x3f;
        abyte0[8] |= 0x80;
        return new UUIT(abyte0);
    }
      
    public String toString() {
        return new StringBuffer().append(digits(mostSigBits >> 32, 8)).append("-").append(digits(mostSigBits >> 16, 4)).append("-").append(digits(mostSigBits, 4)).append("-").append(digits(leastSigBits >> 48, 4)).append("-").append(digits(leastSigBits, 12)).toString();
    }
    public String toString20() {
        return new StringBuffer().append(digits(mostSigBits >> 32, 4)).append(digits(mostSigBits >> 16, 4)).append(digits(mostSigBits, 4)).append(digits(leastSigBits >> 48, 4)).append(digits(leastSigBits, 4)).toString();
    }
    private static String digits(long l, int i) {
        long l1 = 1L << i * 4;
        return Long.toHexString(l1 | l & l1 - 1L).substring(1);
    }

    public int hashCode() {
        if(hashCode == -1)
            hashCode = (int)(mostSigBits >> 32 ^ mostSigBits ^ leastSigBits >> 32 ^ leastSigBits);
        return hashCode;
    }

    private static final long serialVersionUID = 0xbc9903f7986d852fL;
    private final long mostSigBits;
    private final long leastSigBits; 
    private transient int hashCode;
    private static volatile SecureRandom numberGenerator = null;
    
	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
