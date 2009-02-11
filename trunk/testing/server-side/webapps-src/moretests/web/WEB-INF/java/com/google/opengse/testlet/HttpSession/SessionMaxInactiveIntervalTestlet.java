// Copyright 2008 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.opengse.testlet.HttpSession;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jennings
 *         Date: Nov 2, 2008
 */
public class SessionMaxInactiveIntervalTestlet extends HttpServlet {
  private static final int EXPECTED_INTERVAL = 1;

  @Override
  protected void service(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/plain");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession(true);
    session.setMaxInactiveInterval(EXPECTED_INTERVAL);
    int actual = session.getMaxInactiveInterval();
    if (actual != EXPECTED_INTERVAL) {
      out.println("FAILED");
    } else {
      out.println("PASSED");
    }
  }

}