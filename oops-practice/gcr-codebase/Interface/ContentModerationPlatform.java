interface TextModeration {
    void reviewText(String post);

    default void displayModerationPolicy() {
        System.out.println("TextModeration policy: remove offensive or harmful text.");
    }
}

interface SpamDetection {
    void detectSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("SpamDetection policy: block repetitive or promotional spam.");
    }

    static boolean containsRestrictedWords(String post) {
        if (post == null) {
            return false;
        }

        String lowerCasePost = post.toLowerCase();
        String[] restrictedWords = {"hate", "abuse", "scam", "fake", "spam"};
        for (String word : restrictedWords) {
            if (lowerCasePost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    @Override
    public void reviewText(String post) {
        if (SpamDetection.containsRestrictedWords(post)) {
            System.out.println("Offensive post: " + post);
        } else {
            System.out.println("Text reviewed.");
        }
    }

    @Override
    public void detectSpam(String post) {
        String lowerCasePost = post.toLowerCase();
        boolean spam = lowerCasePost.contains("buy now") || lowerCasePost.contains("click here")
                || lowerCasePost.contains("free money") || lowerCasePost.contains("limited offer");
        if (spam) {
            System.out.println("Spam post: " + post);
        } else {
            System.out.println("Not spam.");
        }
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}

public class ContentModerationPlatform {
    public static void main(String[] args) {
        String[] posts = {
                "Buy now and get free money",
                "This movie is amazing",
                "I hate this scam",
                "Click here for a limited offer",
                "Good morning everyone"
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();

        for (String post : posts) {
            boolean offensive = SpamDetection.containsRestrictedWords(post);
            boolean spam = post.toLowerCase().contains("buy now") || post.toLowerCase().contains("click here")
                    || post.toLowerCase().contains("free money") || post.toLowerCase().contains("limited offer");

            if (spam) {
                System.out.println("Spam post: " + post);
            } else if (offensive) {
                System.out.println("Offensive post: " + post);
            } else {
                System.out.println("Valid post: " + post);
            }
        }
    }
}
