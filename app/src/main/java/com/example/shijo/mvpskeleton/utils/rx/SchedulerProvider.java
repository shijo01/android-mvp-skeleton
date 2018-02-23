/*
 * Copyright (c) 2017.
 * Spark Intelligence Labs Private Limited.
 *  All Rights Reserved.
 *
 *  NOTICE:  All information contained herein is, and remains the property of Spark
 *   Intelligence Labs Private Limited. and its suppliers, if any.  The intellectual and
 *   technical concepts contained herein are proprietary to Spark Intelligence Labs
 *   Private Limited and its suppliers and may be covered by India and Foreign Patents,
 *   patents in process, and are protected by trade secret or copyright law. Dissemination
 *   of this information or reproduction of this material is strictly forbidden unless
 *   prior written permission is obtained from Spark Intelligence Labs Private Limited.
 */

package com.example.shijo.mvpskeleton.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by shijo on 13/8/17.
 */

public interface SchedulerProvider {

  Scheduler ui();

  Scheduler computation();

  Scheduler io();

}
