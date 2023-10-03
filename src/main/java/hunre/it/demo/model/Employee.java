package hunre.it.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

	@NotEmpty(message = "Firstname cannot be empty")
  @Column(name = "first_name")
  private String firstName;

  @NotEmpty(message = "Lastname cannot be empty")
  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

}
