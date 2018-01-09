package bean;

import org.apache.ignite.binary.BinaryObjectException;
import org.apache.ignite.binary.BinaryReader;
import org.apache.ignite.binary.BinaryWriter;
import org.apache.ignite.binary.Binarylizable;

import java.io.Serializable;

/**
 * 人脸特征数据封装Bean(对应特征数据存储格式)
 * @author Y.yong
 * 2016年10月27日
 */
public class CacheHumanFeature implements Binarylizable {
	/**
	 * 采集时间
	 */
	private byte[] gatherTime;
	/**
	 * 相机编号
	 */
	private byte[] cameraId;
	/**
	 * 特征数据
	 */
	private float[] feature;
	
	public CacheHumanFeature() {
	}


	public CacheHumanFeature(byte[] gatherTime, byte[] cameraId,
                             float[] feature) {
		super();
		this.gatherTime = gatherTime;
		this.cameraId = cameraId;
		this.feature = feature;
	}

	@Override
	public void writeBinary(BinaryWriter writer) throws BinaryObjectException {
		writer.writeByteArray("gatherTime", gatherTime);
		writer.writeByteArray("cameraId", cameraId);
		writer.writeFloatArray("feature", feature);
	}

	@Override
	public void readBinary(BinaryReader reader) throws BinaryObjectException {
		gatherTime = reader.readByteArray("gatherTime");
		cameraId = reader.readByteArray("cameraId");
		feature = reader.readFloatArray("feature");
	}

	public byte[] getGatherTime() {
		return gatherTime;
	}

	public byte[] getCameraId() {
		return cameraId;
	}

	public void setCameraId(byte[] cameraId) {
		this.cameraId = cameraId;
	}


	public void setGatherTime(byte[] gatherTime) {
		this.gatherTime = gatherTime;
	}

	public float[] getFeature() {
		return feature;
	}

	public void setFeature(float[] feature) {
		this.feature = feature;
	}
}
