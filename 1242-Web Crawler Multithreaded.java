import java.util.*;

class WebCrawlerMultithread {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        // find hostname
        int index = startUrl.indexOf('/', 7);
        String hostname = (index != -1) ? startUrl.substring(0, index) : startUrl;

        // multi-thread
        Crawler crawler = new Crawler(startUrl, hostname, htmlParser);
        // reset result as static property belongs to class, it will go through all of
        // the test cases
        crawler.result = new HashSet<>();  
        Thread thread = new Thread(crawler);
        thread.start();
        // wait for thread to complete
        Crawler.joinThread(thread); 
        return new ArrayList<>(crawler.result);
    }
}

class Crawler implements Runnable {
    String startUrl;
    String hostname;
    HtmlParser htmlParser;
    public static volatile Set<String> result;// = new HashSet<>();

    public Crawler(String startUrl, String hostname, HtmlParser htmlParser) {
        this.startUrl = startUrl;
        this.hostname = hostname;
        this.htmlParser = htmlParser;
    }

    @Override
    public void run() {
        if (this.startUrl.startsWith(hostname) && !this.result.contains(this.startUrl)) {
            addUrl(this.result, this.startUrl);
            List<Thread> threads = new ArrayList<>();
            for (String s : htmlParser.getUrls(startUrl)) {
                if (result.contains(s))
                    continue;
                Crawler crawler = new Crawler(s, hostname, htmlParser);
                Thread thread = new Thread(crawler);
                thread.start();
                threads.add(thread);
            }
            for (Thread t : threads) {
                joinThread(t); // wait for all threads to complete
            }
        }
    }

    public static synchronized void addUrl(Set<String> result, String url) {
        result.add(url);
    }

    public static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface HtmlParser {
    public List<String> getUrls(String url);
}