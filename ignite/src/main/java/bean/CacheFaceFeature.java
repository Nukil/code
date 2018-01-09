package bean;

import org.apache.ignite.binary.BinaryObjectException;
import org.apache.ignite.binary.BinaryReader;
import org.apache.ignite.binary.BinaryWriter;
import org.apache.ignite.binary.Binarylizable;

/**
 * 人脸特征数据封装Bean(对应特征数据存储格式)
 * @author Y.yong
 * 2016年10月27日
 */
public class CacheFaceFeature implements Binarylizable {
    /**
	 * 采集时间
	 */
	private byte[] m_gatherTime;
	/**
	 * 相机编号
	 */
	private byte[] m_cameraId;
	/**
	 * 特征数据
	 */
	private byte[] m_feature;


	@Override
	public void writeBinary(BinaryWriter binaryWriter) throws BinaryObjectException {
	    binaryWriter.writeByteArray("m_gatherTime", m_gatherTime);
	    binaryWriter.writeByteArray("m_cameraId", m_cameraId);
	    binaryWriter.writeByteArray("m_feature", m_feature);
	}

	@Override
	public void readBinary(BinaryReader binaryReader) throws BinaryObjectException {
        m_gatherTime = binaryReader.readByteArray("m_gatherTime");
        m_cameraId = binaryReader.readByteArray("m_cameraId");
        m_feature = binaryReader.readByteArray("m_feature");
	}

    public byte[] getM_gatherTime() {
        return m_gatherTime;
    }

    public void setM_gatherTime(byte[] m_gatherTime) {
        this.m_gatherTime = m_gatherTime;
    }

    public byte[] getM_cameraId() {
        return m_cameraId;
    }

    public void setM_cameraId(byte[] m_cameraId) {
        this.m_cameraId = m_cameraId;
    }

    public byte[] getM_feature() {
        return m_feature;
    }

    public void setM_feature(byte[] m_feature) {
        this.m_feature = m_feature;
    }
}
