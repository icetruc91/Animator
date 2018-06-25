package services;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dataModel.Website;
import model.WebsiteDao;


@RestController
public class WebsiteService {
	
	// http://localhost:8080/Websites
	
	@PostMapping(value="/api/movie")
	public void createWebsiteForDeveloper(@RequestBody Website website, @RequestBody int developerId) {
		WebsiteDao dao = WebsiteDao.getInstance();
		dao.createWebsiteForDeveloper(developerId, website);
	}
	
	@PostMapping(value="/api/movie/{websiteId}")
	public void updateWebsite(@RequestBody Website website, @PathVariable int websiteId) {
		WebsiteDao dao = WebsiteDao.getInstance();
		dao.updateWebsite(websiteId, website);
	}
	
	@GetMapping(value="/api/website")
	public List<Website> findAllWebsites() {
		WebsiteDao dao = WebsiteDao.getInstance();
		return dao.findAllWebsites();
		
	}
	
	@GetMapping(value="/api/website/{developerId}")
	public List<Website> findWebsitesForDeveloper(@PathVariable("developerId") int id) {
		WebsiteDao dao = WebsiteDao.getInstance();
		return dao.findWebsitesForDeveloper(id);
		
	}
	
	@DeleteMapping(value="/api/website/{websiteId}")
	public int deleteWebsite(@PathVariable("websiteId") int id) {
		WebsiteDao dao = WebsiteDao.getInstance();
		return dao.deleteWebsite(id);
		
	}
}
