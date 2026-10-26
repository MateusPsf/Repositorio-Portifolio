package br.com.mateus.portfolio.controller;

import br.com.mateus.portfolio.model.Projeto;
import java.time.Year;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {
    private final List<Projeto> projetos = List.of(
        new Projeto("01", "Estrutura de uma API", "Projeto de aula dedicado à organização e à estrutura de uma API.",
            "backend", "API · Backend", "https://github.com/MateusPsf/Aula-estrutura-projetoapi"),
        new Projeto("02", "Meu primeiro portfólio", "O ponto de partida: uma página pessoal criada nas aulas com HTML e CSS.",
            "frontend", "HTML · CSS · JavaScript", "https://github.com/MateusPsf/Atividade_Portifolio")
    );

  
    @GetMapping({"/", "/projetos"})
    public String portfolio(@RequestParam(defaultValue = "todos") String categoria, Model model) {
        String filtro = List.of("frontend", "backend").contains(categoria) ? categoria : "todos";
        model.addAttribute("nome", "Mateus Fernandes");
        model.addAttribute("descricao", "Sou formado em Análise e Desenvolvimento de Sistemas e estudante de Sistemas de Informação. Tenho conhecimentos em Java, Python, PHP e outras tecnologias. Gosto de transformar aprendizado em projetos e estou sempre buscando evoluir como desenvolvedor.");
        model.addAttribute("habilidades", List.of("Java", "Python", "PHP", "HTML", "CSS", "JavaScript", "Spring Boot", "Thymeleaf"));
        model.addAttribute("projetos", projetos.stream().filter(p -> filtro.equals("todos") || p.categoria().equals(filtro)).toList());
        model.addAttribute("categoriaAtiva", filtro);
        model.addAttribute("ano", Year.now().getValue());
        return "index";
    }
}
