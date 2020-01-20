package models;

import java.util.Objects;

public class News {
    private int newsId;
    private String headline;
    private String content;


    public News(String headline, String content){
        this.headline = headline;
        this.content = content;
    }
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return newsId == news.newsId &&
                Objects.equals(headline, news.headline) &&
                Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, headline, content);
    }
}
