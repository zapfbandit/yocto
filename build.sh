#!/bin/bash

chmod +x $(pwd)/buildtools/environment-setup-x86_64-pokysdk-linux
$(pwd)/buildtools/environment-setup-x86_64-pokysdk-linux
export PATH=$PATH:$(pwd)/buildtools/sysroots/x86_64-pokysdk-linux/usr/bin
export PATH=$PATH:$(pwd)/bitbake/bin

cd build

log="yocto.log"
echo -e "*****************************" |& tee -a $log
echo "Yocto build started at" |& tee $log
date |& tee -a $log
echo -e "*****************************" |& tee -a $log

echo -e "\n--------\nCleaning\n--------\n"
bitbake core-image-minimal u-boot-socfpga adt -c cleanall -f |& tee -a $log

echo -e "\n--------\nBuilding\n--------\n"
bitbake core-image-minimal |& tee -a $log

rm -f ~/yocto_intel_wic.gz
echo -e "\nZipping up WIC image"
pv ./tmp/deploy/images/arria10/core-image-minimal-arria10-*.rootfs.wic | gzip -fckN9 > ~/yocto_intel_wic.gz

echo -e "\n*****************************" |& tee -a $log
echo -e "Yocto build finished at" |& tee -a $log
date |& tee -a $log
echo -e "*****************************\n" |& tee -a $log
