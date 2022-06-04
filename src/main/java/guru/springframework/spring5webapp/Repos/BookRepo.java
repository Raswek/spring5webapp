package guru.springframework.spring5webapp.Repos;

import guru.springframework.spring5webapp.Entities.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;

@Component
public interface BookRepo extends CrudRepository<Book,Integer>
{
}
