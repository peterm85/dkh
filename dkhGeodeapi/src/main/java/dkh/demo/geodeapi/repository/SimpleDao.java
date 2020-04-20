package dkh.demo.geodeapi.repository;

public interface SimpleDao {
	String get(String key);
	void create(String key, String value);
}
