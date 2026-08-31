package cp4_parte2_mvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "TDS_MVC_TB_MERCADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mercado_seq")
    @SequenceGenerator(
            name = "mercado_seq",
            sequenceName = "TDS_MVC_SEQ_MERCADO",
            allocationSize = 1
    )
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O tipo do produto é obrigatório")
    @Size(max = 60, message = "O tipo deve ter no máximo 60 caracteres")
    @Column(name = "TIPO", nullable = false, length = 60)
    private String tipo;

    @NotBlank(message = "O setor é obrigatório")
    @Size(max = 60, message = "O setor deve ter no máximo 60 caracteres")
    @Column(name = "SETOR", nullable = false, length = 60)
    private String setor;

    @NotBlank(message = "O tamanho é obrigatório")
    @Size(max = 40, message = "O tamanho deve ter no máximo 40 caracteres")
    @Column(name = "TAMANHO", nullable = false, length = 40)
    private String tamanho;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    @Column(name = "PRECO", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
}