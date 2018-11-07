package cz.stepanbohm.moneta.numberformater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private NumberFormater numberFormater;

	@GetMapping(path = "number/{number}")
	public Long formatNumber(@PathVariable Long number) {
		return numberFormater.formatNumberLong(number);
	}

	@PostMapping(path = "number")
	public FormatedNumber formatNumber(@RequestBody InputNumber number) {
		return numberFormater.formatNumber(number);
	}
}
