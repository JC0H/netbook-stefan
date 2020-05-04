package pl.laptopy.polizingowe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.dto.BlogDto;
import pl.laptopy.polizingowe.entity.Blog;
import pl.laptopy.polizingowe.mapper.BlogMapper;
import pl.laptopy.polizingowe.repository.BlogRepository;
import pl.laptopy.polizingowe.service.BlogService;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final ListConverter<Blog> blogListConverter;
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public List<BlogDto> findAll() {
        List<Blog> blogList = blogListConverter.convertIterableToList(blogRepository.findAll());
        return blogMapper.toBlogDtoList(blogList);
    }

    @Override
    public void deleteBlogById(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public BlogDto findOne(Long id) {
        Blog blogById = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("No such Blog."));
        return blogMapper.mapBlogToDto(blogById);
    }

    @Override
    public void saveBlog(BlogDto blogDto) {
        Blog blog = blogMapper.mapBlogToDto(blogDto);
        blogRepository.save(blog);
    }
}
