package pl.laptopy.polizingowe.repository;

import org.springframework.data.repository.CrudRepository;
import pl.laptopy.polizingowe.entity.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
