package br.edu.iff.LojaDeAlimentos.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MainRestController {

	@GetMapping
	@ResponseBody
	public String initial() {
		return "teste";
	}

	/*
	  @GetMapping("/{id}") public String page (@PathVariable("id") int id) { return
	  "teste " + id; }
	  
	  
	  @GetMapping("/{id}") public String page2 (@PathVariable("id") int
	  id, @RequestParam("nome") String nome) { return "teste " + id + " nome " +
	  nome; }
	 */

	/*
	  @PostMapping("/new")	 
	  @ResponseBody public String addItem(@RequestParam Map<String, String>
	  allParams) { return "Os parametros foram " + allParams.entrySet(); }
	  
	  @GetMapping("/teste/{id}") public ResponseEntity<?>
	  buscar(@PathVariable("id") String id) { if (id.equals("123")) { return
	  ResponseEntity.ok().header("Content-Type",
	  "text/html").body("<h1>Sucesso!</h1>"); } else { return
	  ResponseEntity.notFound().header("Content-Type", "text/html").build(); } }
	 */

	/*
	  @PostMapping("/new/users")
	  
	  @ResponseStatus(HttpStatus.CREATED) public Map<String, String>
	  registerUser(@RequestParam Map<String, String> userMap) { try { if
	  (userMap.get("userName") == null || userMap.get("password") == null ||
	  userMap.get("password") == "" || userMap.get("userName") == "") { throw new
	  NullPointerException(); } System.out.println("User ID: " +
	  userMap.get("userName")); System.out.println("User ID: " +
	  userMap.get("password")); return userMap; } catch (Exception e) {
	  System.out.println("Insira os valores!"); Map<String, String> erro = new
	  HashMap<>(); erro.put("Erro", "Insira os valores!"); return erro; } }
	 */

	

}
