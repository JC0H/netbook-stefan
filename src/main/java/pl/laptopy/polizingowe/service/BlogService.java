package pl.laptopy.polizingowe.service;

import pl.laptopy.polizingowe.dto.BlogDto;

import java.util.List;

public interface BlogService {

    List<BlogDto> findAll();

    void deleteBlogById(Long id);

    BlogDto findOne(Long id);

    void saveBlog(BlogDto blogDto);
}
