package harjo.basic.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListTranscoder<T extends Serializable> extends SerializeTranscoder {

	@SuppressWarnings("unchecked")
	@Override
	public byte[] serialize(Object value) {
		if (value == null)
			throw new NullPointerException("Can't serialize null");

		List<T> values = (List<T>) value;
		byte[] results = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;

		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			for (T m : values) {
				os.writeObject(m);
			}

			// os.writeObject(null);
			os.close();
			bos.close();
			results = bos.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Non-serializable object", e);
		} finally {
			close(os);
			close(bos);
		}

		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> deserialize(byte[] in) {
		List<T> list = new ArrayList<>();
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				while (true) {
					T t = (T) is.readObject();
					if (t == null) {
						break;
					}

					list.add(t);
				}
				is.close();
				bis.close();
			}
		} catch (IOException e) {
			logger.error(String.format("Caught IOException decoding %d bytes of data", in == null ? 0 : in.length) + e);
		} catch (ClassNotFoundException e) {
			logger.error(String.format("Caught CNFE decoding %d bytes of data", in == null ? 0 : in.length) + e);
		} finally {
			close(is);
			close(bis);
		}

		return list;
	}

}
