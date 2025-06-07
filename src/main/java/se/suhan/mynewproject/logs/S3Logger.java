package se.suhan.mynewproject.logs;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class S3Logger {

    private final S3Client s3Client;
    private final String bucketName = "suhanassite";
    private final ZoneId zone = ZoneId.of("Europe/Stockholm"); // Change to your desired time zone
    private final Region awsRegion = Region.of("eu-north-1"); // Change to your AWS region

    public S3Logger() {
        this.s3Client = S3Client.builder()
                .region(awsRegion)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    public void logLogin(String userId, String email) {
        ZonedDateTime now = ZonedDateTime.now(zone);
        String isoTimestamp = now.toInstant().toString();
        String humanReadable = now.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss z"));

        // One-line JSON log
        String logEntry = String.format(
                "{\"userId\":\"%s\",\"email\":\"%s\",\"timestamp_iso\":\"%s\",\"timestamp_human\":\"%s\"}\n",
                userId, email, isoTimestamp, humanReadable
        );

        String dateKey = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String objectKey = "logins/" + dateKey + ".log";

        try {
            // Try to fetch current content of log file
            String existingContent = "";
            try {
                GetObjectRequest getReq = GetObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build();
                existingContent = s3Client.getObjectAsBytes(getReq).asUtf8String();
            } catch (NoSuchKeyException e) {
                // First log entry of the day
            }

// Append log entry
            String updatedContent = existingContent + logEntry;

            PutObjectRequest putReq = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .contentType("text/plain")
                    .build();

            s3Client.putObject(putReq, RequestBody.fromString(updatedContent, StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.err.println("S3 logging failed: " + e.getMessage());
        }
    }
}
