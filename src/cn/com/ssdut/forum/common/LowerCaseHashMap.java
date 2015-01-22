package cn.com.ssdut.forum.common;


import java.util.HashMap;

/**
 * 不区分大小写key的Map
 *
 * @param <K> 键名类型
 * @param <V> 键值类型
 * 
 */
public class LowerCaseHashMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = -8070414666027286684L;

	private Object getKey1(Object o) {
		if (o instanceof String) {
			return ((String) o).toLowerCase();
		} else {
			return o;
		}
	}

	@SuppressWarnings("unchecked")
	private K getKey2(K o) {
		if (o instanceof String) {
			return (K) ((String) o).toLowerCase();
		} else {
			return o;
		}
	}

	public LowerCaseHashMap() {
		super();
	}

	public LowerCaseHashMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		return super.containsKey(getKey1(key));
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public V get(Object key) {
		return super.get(getKey1(key));
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public V put(K key, V value) {
		return super.put(getKey2(key), value);
	}

	/**
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public V remove(Object key) {
		return super.remove(getKey1(key));
	}
}