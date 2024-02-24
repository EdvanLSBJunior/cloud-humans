package com.example.cloudhuman.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Projects {
    CALCULATE_DARK_MATTER_NASA(10, "Calcular a Matéria Escura do universo para a Nasa"),
    DETERMINE_SCHRODINGER_CAT_IS_ALIVE(5, "Determinar se o gato de Schrodinger está vivo"),
    SUPPORT_USERS_FROM_XYZ(3, "Atender ao suporte de usuários para a empresa YXZ"),
    COLLECT_INFORMATION_FOR_XPTO(2, "Coletar informações específicas das pessoas de suas redes sociais para a empresa XPTO");

    private int minScore;
    private String description;
}
