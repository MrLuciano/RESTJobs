/**
 * 
 */
package net.my.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.my.spring.dao.JobDAO;
import net.my.spring.model.Job;

/**
 * REST controller para realizar operações CRUD no caminho /jobs
 * 
 * @author Luciano Marinho
 *
 */
@RestController
public class JobRestController {

	@Autowired
	private JobDAO jobDAO;
	
	/**
	 * GET all
	 * Lista todos os Jobs armazenados
	 * 
	 * @return
	 */
	@GetMapping("/jobs")
	public List getJobs() {
		return jobDAO.list();
	}
	
	/**
	 * GET name
	 * Retorna o objeto nomeado 
	 *
	 * @param name
	 * @return
	 */
	@GetMapping("/jobs/{name}")
	public ResponseEntity getJob(@PathVariable("name") String name ) {
		Job job = jobDAO.get(name);
		if ( job == null ) {
			return new ResponseEntity("Job não encontrado <" + name + ">", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(job, HttpStatus.OK);
	}
	
//	/**
//	 * POST object
//	 * A lista de objeto json vai no request body.
//	 * 
//	 * @param job
//	 * @return
//	 */
//	@PostMapping(value = "/jobs")
//	public ResponseEntity createJobs(@RequestBody List<Job> jobs) {
//		
//		List<Job> ret = new ArrayList<Job>();
//		
//		for (Job job2 : jobs) {
//			ret.add(jobDAO.create(job2));
//		}
//		
//		return new ResponseEntity(ret, HttpStatus.OK);
//	}
	
	/**
	 * POST object
	 * O objeto json vai no request body.
	 * 
	 * @param job
	 * @return
	 */
	@PostMapping(value = "/jobs")
	public ResponseEntity createJob(@RequestBody Job job) {
		
		Job resp = jobDAO.create(job);
		return new ResponseEntity(resp, HttpStatus.OK);
	}
	/**
	 * DELETE name
	 * 
	 * @param name nome do job a ser excluído
	 * @return
	 */
	@DeleteMapping("/jobs/{name}")
	public ResponseEntity deleteJob(@PathVariable String name) {
		
		if (jobDAO.delete(name) == null) {
			return new ResponseEntity("Job não encontrado : " + name, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(name, HttpStatus.OK);
	}
	
	/**
	 * PUT name
	 * 
	 * @param name nome do job a ser alterado
	 * @param job request body
	 * @return
	 */
	@PutMapping("/jobs/{name}")
	public ResponseEntity updateJob(@PathVariable String name, @RequestBody Job job){
		
		if (jobDAO.update(name, job) == null) {
			return new ResponseEntity("Job não encontrado : " + name, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(job, HttpStatus.OK);
	}
}
