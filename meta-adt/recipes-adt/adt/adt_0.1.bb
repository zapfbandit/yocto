SUMMARY = "ADT Files Recipe"

DESCRIPTION = "Add the files required for the board image to have all the required software and be able to be made read-only."

LICENSE = "CLOSED"

SRC_URI += " \
    file://files/etc/resolv.conf \
    file://files/etc/network/interfaces \
    file://files/home/root/.ssh/devkey \
    file://files/home/root/.ssh/devkey.pub \
"

do_install() {

   install -d ${D}${base_prefix}/etc/
   install -m 666 ${WORKDIR}/files/etc/resolv.conf           ${D}${base_prefix}/etc/
   
   install -d ${D}${base_prefix}/etc/network/
   install -m 666 ${WORKDIR}/files/etc/network/interfaces    ${D}${base_prefix}/etc/network/
   
   install -d ${D}${base_prefix}/home/root/.ssh/
   install -m 666 ${WORKDIR}/files/home/root/.ssh/devkey     ${D}${base_prefix}/home/root/.ssh/
   install -m 666 ${WORKDIR}/files/home/root/.ssh/devkey.pub ${D}${base_prefix}/home/root/.ssh/   
}

FILES_${PN} += " \
   ${base_prefix}/etc/resolv.conf \
   ${base_prefix}/etc/network/interfaces \
   ${base_prefix}/files/home/root/.ssh/devkey \
   ${base_prefix}//files/home/root/.ssh/devkey.pub \
"
