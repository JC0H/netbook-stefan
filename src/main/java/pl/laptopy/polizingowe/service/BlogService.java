package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.dto.BlogDto;
import pl.laptopy.polizingowe.entity.Blog;
import pl.laptopy.polizingowe.mapper.BlogMapper;
import pl.laptopy.polizingowe.repository.BlogRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final ListConverter<Blog> blogListConverter;
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public List<BlogDto> findAll() {
        List<Blog> blogs = blogListConverter.convertIterableToList(blogRepository.findAll());
        return blogMapper.toBlogDtoList(blogs);
    }
}
