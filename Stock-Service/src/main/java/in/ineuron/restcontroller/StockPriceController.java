package in.ineuron.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceController {
	
	@Autowired
	private IStockPriceService servie;
	
	@GetMapping("/stockPrice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String companyName){
		
		Double price = servie.findByCompanyName(companyName);
		System.out.println("Company Name is :: "+companyName+" & Price is :: "+price);
		
		return new ResponseEntity<Double>(price,HttpStatus.OK);
	}

}
