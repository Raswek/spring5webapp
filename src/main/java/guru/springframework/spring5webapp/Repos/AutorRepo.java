package guru.springframework.spring5webapp.Repos;

import guru.springframework.spring5webapp.Entities.*;
import org.springframework.data.repository.*;

public interface AutorRepo extends CrudRepository<Author, Integer>
{
}
