/**
 * 
 */
package net.my.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.my.spring.model.Job;

/**
 * @author Luciano Marinho
 *
 */
@Component
public class JobDAO {

	//Banco de dados local de testes, para carregar a lista de jobs
	//pode ser colocado na crontab
	private static List<Job> jobs;
	{
		jobs = new ArrayList<Job>();
//		jobs.add(new Job("job1", "Mensagem 1", "* * * * *"));
//		jobs.add(new Job("job2", "Mensagem 2", "* * * * *"));
//		jobs.add(new Job("job3", "Mensagem 3", "* * * * *"));
	}
	
	/**
	 * Lista todas as entradas de jobs
	 * @return
	 */
	public List<Job> list() {
		//acompanhamento no log
		showJobs();
		
		return jobs;
	}
	
	/**
	 * Retorna um job com o dado nome 
	 * @param jobname nome do job
	 * @return objeto do Job 
	 */
	public Job get(String jobname) {
		
		for (Object j : jobs) {
			if (((Job)j).getName().equalsIgnoreCase(jobname) ) {
				return (Job)j;
			}
		}
		return null;
	}
	
	/**
	 * Cria um job no bd 
	 * @param job
	 * @return
	 */
	public Job create(Job job) {
		if ( job != null ) {
			jobs.add(job);
		}
		return job;
	}
	
	/**
	 * Exclui o job 
	 * @param jobname
	 * @return o nome do job ou vazio se não encontrar
	 */
	public String delete (String jobname) {
		
		System.out.println("metodo Delete() - Antes ");
		showJobs();
		for (Object o : jobs) {
			if ( ((Job)o).getName().equalsIgnoreCase(jobname)) {
				jobs.remove(o);
				return ((Job)o).getName();
			}
		}
		System.out.println("metodo Delete() - Depois ");
		showJobs();
		return "";
	}
	

	/**
	 * Atualiza um determinado job pelo nome
	 * @param jobname
	 * @param jobi
	 * @return o objeto jobi se for sucesso, nulo se não encontrar
	 */
	public Job update (String jobname, Job jobi) {
		
		for (Object o : jobs) {
			if (((Job) o).getName().equalsIgnoreCase(jobname)) {
				jobs.remove(o);
				jobs.add(jobi);
				return jobi;
			}
		}
		return null;
	}
	
	/**
	 * Mostra todos os jobs
	 */
	private void showJobs() {
		for (Object o : jobs) {	
			Job job = (Job) o;
			showMsg(job);
		}
	}
	
	/**
	 * Mostra a msg do job
	 * @param job
	 */
	private void showMsg(Job job) {
		if ( job != null ) {
			System.out.println(job.getMsg());
		}
	}
}
