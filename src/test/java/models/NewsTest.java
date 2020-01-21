package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    public News setUpNews(){
        return new News ("Hot News", "This is breaking news",  1);
    }

    @Test
    public void instantiates(){
        News newNews = setUpNews();
        assertEquals(true, newNews instanceof News);
    }


    @Test
    public void getHeadlineTest() {
        News newNews = setUpNews();
        assertEquals("Hot News", newNews.getHeadline());
    }


    @Test
    public void setHeadlineTest() {
        News newNews = setUpNews();
        newNews.setHeadline("Now");
        assertEquals("Now", newNews.getHeadline());
    }


    @Test
    public void getContentTest() {
        News newNews = setUpNews();
        newNews.setContent("This is hot news");
        assertEquals("This is hot news", newNews.getContent());
    }

    @Test
    public void setNewsIdTest() {
        News newNews = setUpNews();
        newNews.setNewsId(5);
        assertEquals(5, newNews.getNewsId());
    }

    @Test
    public void getNewsIdTest() {
        News newNews = setUpNews();
        assertEquals(0, newNews.getNewsId());
    }
    @Test
    public void getDepartmentIdTest() {
        News newNews = setUpNews();
        newNews.setDepartment_id(5);
        assertEquals(5, newNews.getDepartment_id());
    }

    @Test
    public void setDepartmentIdTest() {
        News newNews = setUpNews();
        newNews.setDepartment_id(7);
        assertEquals(7, newNews.getDepartment_id());
    }

}