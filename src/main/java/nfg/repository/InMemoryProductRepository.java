package nfg.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nfg.model.Izdelek;

public class InMemoryProductRepository {
	private static Map<Long, Izdelek> izdelki = new HashMap<Long, Izdelek>();
	private static Long idIndex = 3L;
	
	static {
		Izdelek a = new Izdelek(1L, "Mleko", 2.99, "MLE102332");
		izdelki.put(1L, a);
		Izdelek b = new Izdelek(2L, "Kruh", 1.59, "KRU112335");
		izdelki.put(2L, b);
		Izdelek c = new Izdelek(3L, "Marmelada", 3.20, "MAR048960");
		izdelki.put(3L, c);
	}
	
	public static List<Izdelek> list() {
		return new ArrayList<Izdelek>(izdelki.values());
	}

	public static Izdelek create(Izdelek izdelek) {
		idIndex += idIndex;
		izdelek.setId(idIndex);
		izdelki.put(idIndex, izdelek);
		return izdelek;
	}

	public static Izdelek delete(Long id) {
		return izdelki.remove(id);
	}

	public static Izdelek update(Long id, Izdelek izdelek) {
		izdelki.put(id, izdelek);
		return izdelek;
	}

	public static Izdelek get(Long id) {
		return izdelki.get(id);
	}

}
