package pl.laptopy.polizingowe.mapper;

import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.BlogDto;
import pl.laptopy.polizingowe.entity.Blog;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlogMapper {


    public List<BlogDto> toBlogDtoList(List<Blog> blogList) {
        return blogList.stream()
        .map(this::mapBlogToDto)
        .collect(Collectors.toList());
    }

    public BlogDto mapBlogToDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .build();
    }

    public Blog mapBlogToDto(BlogDto blogDto) {
        return Blog.builder()
                .id(blogDto.getId())
                .title(blogDto.getTitle())
                .content(blogDto.getContent())
                .build();
    }
}
