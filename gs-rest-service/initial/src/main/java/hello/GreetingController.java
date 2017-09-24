package hello;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class GreetingController {
	
	ArrayList<Greeting> data = new ArrayList<Greeting>();
	
	 @CrossOrigin(origins = "http://localhost:9000")
	 @RequestMapping(value = "/add",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<Greeting> update(@RequestBody Greeting gt){
		 data.add(gt);
		 return new ResponseEntity<Greeting>(gt,HttpStatus.OK);
	 }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/get",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Greeting[] greeting(){
    		Greeting[] my = data.toArray(new Greeting[data.size()]);
    		return my;
    }
    
}