package br.com.example.produto.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

@Configuration
@Getter
public class S3ClientConfig {

    @Value("${spring.aws-s3.accessKey}")
    private String accessKey;

    @Value("${spring.aws-s3.secretKey}")
    private String secretKey;

    @Value("${spring.aws-s3.bucket}")
    public String bucket;


    public S3Client s3Client() {

        return S3Client.builder()
                .region(Region.SA_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey,secretKey)))
                .build();
    }

    @PostConstruct
    public void teste(){
        ListBucketsResponse list = s3Client().listBuckets();

        list.buckets().forEach(x -> System.out.println(x.name()));

        s3Client().close();
    }
}
