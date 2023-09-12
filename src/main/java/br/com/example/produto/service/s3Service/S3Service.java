package br.com.example.produto.service.s3Service;

import br.com.example.produto.config.S3ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.net.URL;

@Service
public class S3Service {

    @Autowired
    private S3ClientConfig s3ClientConfig;

    public String uploadImage(MultipartFile file) {

        try {
            PutObjectResponse response = s3ClientConfig.s3Client().putObject(PutObjectRequest.builder()
                            .bucket(s3ClientConfig.getBucket())
                            .key(file.getOriginalFilename())
                            .build(),
                    RequestBody.fromBytes(file.getBytes()));

        } catch (Exception e){
            System.out.println(e);
        }


        URL url = s3ClientConfig.s3Client().utilities().getUrl(GetUrlRequest.builder()
                .bucket(s3ClientConfig.getBucket())
                .key(file.getOriginalFilename())
                .build());

        return url.toString();
    }

}
