package nfg.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nfg.model.Izdelek;
//import nfg.repository.InMemoryProductRepository;
import nfg.repository.IzdelekRepository;

@RestController
@RequestMapping("api/v1/")
public class IzdelekController {
	
	@Autowired
	private IzdelekRepository izdelekRepository;
	
	@RequestMapping(value = "izdelki", method = RequestMethod.GET)
	public List<Izdelek> list() {
//		return InMemoryProductRepository.list();
		return izdelekRepository.findAll();
	}
	
	@RequestMapping(value = "izdelki", method = RequestMethod.POST)
	public Izdelek create(@RequestBody Izdelek izdelek) {
//		return InMemoryProductRepository.create(izdelek);
		return izdelekRepository.saveAndFlush(izdelek);
	}

	@RequestMapping(value = "izdelki/{id}", method = RequestMethod.GET)
	public Izdelek get(@PathVariable Long id) {
//		return InMemoryProductRepository.get(id);
		return izdelekRepository.findOne(id);
	}
	
	@RequestMapping(value = "izdelki/{id}", method = RequestMethod.PUT)
	public Izdelek update(@PathVariable Long id, @RequestBody Izdelek izdelek) {
//		return InMemoryProductRepository.update(id, izdelek);
		Izdelek i = izdelekRepository.findOne(id);
		BeanUtils.copyProperties(izdelek, i);
		return izdelekRepository.saveAndFlush(i);
	}
	
	@RequestMapping(value = "izdelki/{id}", method = RequestMethod.DELETE)
	public Izdelek delete(@PathVariable Long id) {
//		return InMemoryProductRepository.delete(id);
		Izdelek i = izdelekRepository.findOne(id);
		izdelekRepository.delete(i);
		return i;
	}
}
