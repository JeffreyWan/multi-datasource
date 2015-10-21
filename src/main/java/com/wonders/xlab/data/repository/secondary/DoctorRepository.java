package com.wonders.xlab.data.repository.secondary;

import com.wonders.xlab.data.entity.secondary.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jeffrey on 15/10/21.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
