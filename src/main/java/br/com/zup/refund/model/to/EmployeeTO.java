package br.com.zup.refund.model.to;

import br.com.zup.refund.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTO extends MainTO<EmployeeTO, Employee>{

    private Long id;

    private String name;

    private String email;
}
