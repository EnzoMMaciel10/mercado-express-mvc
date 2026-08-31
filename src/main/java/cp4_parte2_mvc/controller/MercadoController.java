package cp4_parte2_mvc.controller;

import cp4_parte2_mvc.model.Mercado;
import cp4_parte2_mvc.service.MercadoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mercado")
public class MercadoController {

    private final MercadoService mercadoService;

    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        model.addAttribute("mercados", mercadoService.buscarPorNome(busca));
        model.addAttribute("busca", busca);
        return "mercado/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("mercado", new Mercado());
        model.addAttribute("titulo", "Novo produto");
        model.addAttribute("acao", "/mercado");
        return "mercado/form";
    }

    @PostMapping
    public String salvar(
            @Valid @ModelAttribute("mercado") Mercado mercado,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Novo produto");
            model.addAttribute("acao", "/mercado");
            return "mercado/form";
        }

        mercadoService.salvar(mercado);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/mercado";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("mercado", mercadoService.buscarPorId(id));
        return "mercado/detalhes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("mercado", mercadoService.buscarPorId(id));
        model.addAttribute("titulo", "Editar produto");
        model.addAttribute("acao", "/mercado/editar/" + id);
        return "mercado/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(
            @PathVariable Long id,
            @Valid @ModelAttribute("mercado") Mercado mercado,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        mercado.setId(id);

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar produto");
            model.addAttribute("acao", "/mercado/editar/" + id);
            return "mercado/form";
        }

        mercadoService.salvar(mercado);
        redirectAttributes.addFlashAttribute("sucesso", "Produto atualizado com sucesso!");
        return "redirect:/mercado";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        mercadoService.excluir(id);
        redirectAttributes.addFlashAttribute("sucesso", "Produto excluído com sucesso!");
        return "redirect:/mercado";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String tratarErro(IllegalArgumentException erro, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("erro", erro.getMessage());
        return "redirect:/mercado";
    }
}