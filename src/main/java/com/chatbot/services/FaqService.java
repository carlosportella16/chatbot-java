package com.chatbot.services;

import com.chatbot.domain.FaqAnswer;
import com.chatbot.utils.FaqAnswers;
import org.springframework.stereotype.Service;
import java.text.Normalizer;


import java.util.List;
import java.util.stream.Stream;

@Service
public class FaqService {
    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question) {
        // Remove a acentuacao e caracteres especiais
        String questionFormated = removerAcentos(question);
        // Separa as palavras da frase por espaço e coloca em lower case.
        List<String> words = Stream.of(questionFormated.toLowerCase().split("\\s+")).map(String::toLowerCase).toList();
        System.out.println(words);
        // removendo acentuação gráfica das palavras
        for (FaqAnswer entry : faqAnswers.getAnswers()) {
            for (String keyword : entry.getKeywords()) {
                if (words.contains(keyword.toLowerCase())) {
                    return entry.getAnswer();
                }
            }
        }
        return faqAnswers.getDefaultAnswer();
    }

    public String removerAcentos(String texto) {
        // Utiliza a classe Normalizer para normalizar o texto com o Formato NFKD
        // e então remove todos os caracteres que não são letras ou números
        texto = Normalizer.normalize(texto, Normalizer.Form.NFKD);
        texto = texto.replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^\\p{IsAlphabetic}\\s]", "");
        return texto;
    }
}
