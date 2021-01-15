package src;

public class KeyValue <V> {
	protected int key;
	protected V value;
	
	public KeyValue() {
		key = 0;
		value = null;
	}
	
	public KeyValue(int key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public KeyValue(KeyValue object) {
		this.key = object.key;
		this.value = (V) object.value;
	}
	
	public int getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public KeyValue clone(KeyValue object) {
		return new KeyValue(object);
	}
	
	public String toString() {
		return (key + " " + value);
	}

}
